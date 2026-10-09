import sqlite3
from flask import Flask, render_template, request, jsonify, redirect, url_for, flash

app = Flask(__name__)
app.secret_key = "iron_dih_inc_secret_key"

DATABASE = 'database.db'

def get_db_connection():
    conn = sqlite3.connect(DATABASE)
    conn.row_factory = sqlite3.Row
    return conn

@app.route('/')
def index():
    conn = get_db_connection()
    # Fetch first 10 featured books for home grid
    featured_books = conn.execute('SELECT * FROM library ORDER BY id DESC LIMIT 10').fetchall()
    
    # Fetch all books for full search / view all modal
    all_books = conn.execute('SELECT * FROM library ORDER BY title ASC').fetchall()
    
    # Fetch requests joined with usernames
    requests_list = conn.execute('''
        SELECT r.*, u.username 
        FROM requests r 
        JOIN users u ON r.user_id = u.user_id 
        ORDER BY r.request_id DESC
    ''').fetchall()
    
    # Fetch community resources
    resources_list = conn.execute('''
        SELECT cr.*, u.username AS manager 
        FROM community_resources cr 
        LEFT JOIN users u ON cr.managed_by_user_id = u.user_id
    ''').fetchall()
    
    conn.close()
    return render_template(
        'index.html', 
        featured_books=featured_books,
        all_books=all_books,
        requests=requests_list,
        resources=resources_list
    )

@app.route('/add-book', methods=['POST'])
def add_book():
    title = request.form.get('title', '').strip()
    author = request.form.get('author', '').strip()
    genre = request.form.get('genre', '').strip()
    lexile = request.form.get('lexile', '').strip()

    if not title or not author or not genre:
        flash('Title, Author, and Genre are required!', 'error')
        return redirect(url_for('index'))

    lexile_val = int(lexile) if lexile.isdigit() else None

    conn = get_db_connection()
    conn.execute(
        'INSERT INTO library (title, author, genre, lexile) VALUES (?, ?, ?, ?)',
        (title, author, genre, lexile_val)
    )
    conn.commit()
    conn.close()

    flash(f'Book "{title}" added successfully to SQLite database!', 'success')
    return redirect(url_for('index'))

@app.route('/api/search')
def api_search():
    q = request.args.get('q', '').strip()
    conn = get_db_connection()
    if q:
        books = conn.execute(
            'SELECT * FROM library WHERE title LIKE ? OR author LIKE ? OR genre LIKE ?',
            (f'%{q}%', f'%{q}%', f'%{q}%')
        ).fetchall()
    else:
        books = conn.execute('SELECT * FROM library ORDER BY title ASC').fetchall()
    conn.close()

    return jsonify([dict(b) for b in books])

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)