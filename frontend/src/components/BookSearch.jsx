import { useState } from 'react'
import { searchBooks } from '../services/bookService'
import './BookSearch.css'

function BookSearch() {
    const [query, setQuery] = useState('')
    const [books, setBooks] = useState([])
    const [loading, setLoading] = useState(false)

    const handleSearch = async (e) => {
        const value = e.target.value
        setQuery(value)
        if (value.length < 2) {
            setBooks([])
            return
        }
        setLoading(true)
        const results = await searchBooks(value)
        setBooks(results)
        setLoading(false)
    }

    return (
        <div className="search-container">
            <div className="search-box">
                <svg className="search-icon" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5">
                    <circle cx="11" cy="11" r="8"/><path d="m21 21-4.35-4.35"/>
                </svg>
                <input
                    type="text"
                    placeholder="Busca por título o autor..."
                    value={query}
                    onChange={handleSearch}
                    className="search-input"
                />
            </div>

            {loading && <p className="loading">Buscando...</p>}

            <div className="books-list">
                {books.map(book => (
                    <div key={book.googleId} className="book-card">
                        <div className="book-cover">
                            {book.coverUrl
                                ? <img src={book.coverUrl} alt={book.title} />
                                : <div className="no-cover">Sin portada</div>
                            }
                        </div>
                        <div className="book-info">
                            <h3 className="book-title">{book.title}</h3>
                            <p className="book-author">{book.author}</p>
                            <p className="book-pages">{book.pages} páginas</p>
                            {book.description && (
                                <p className="book-description">
                                    {book.description.slice(0, 300)}...
                                </p>
                            )}
                            <button className="book-btn">Crear club</button>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    )
}

export default BookSearch