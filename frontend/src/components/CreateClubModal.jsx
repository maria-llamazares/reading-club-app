import { useState } from 'react'
import axios from 'axios'
import './CreateClubModal.css'

function CreateClubModal({ book, onClose, onCreated }) {
    const [totalWeeks, setTotalWeeks] = useState(4)
    const [loading, setLoading] = useState(false)

    const handleCreate = async () => {
        setLoading(true)
        try {
            const response = await axios.post('http://localhost:8080/api/clubs/create', {
                book: book.title,
                author: book.author,
                googleId: book.googleId,
                coverUrl: book.coverUrl,
                description: book.description,
                pages: book.pages,
                totalWeeks
            })
            onCreated(response.data)
        } catch (error) {
            console.error('Error creando club:', error)
        }
        setLoading(false)
    }

    return (
        <div className="modal-overlay" onClick={onClose}>
            <div className="modal" onClick={e => e.stopPropagation()}>
                <button className="modal-close" onClick={onClose}>✕</button>
                <div className="modal-cover">
                    {book.coverUrl && <img src={book.coverUrl} alt={book.title} />}
                </div>
                <h2 className="modal-title">{book.title}</h2>
                <p className="modal-author">{book.author}</p>
                <p className="modal-pages">{book.pages} páginas</p>

                <div className="modal-field">
                    <label>Duración del club</label>
                    <select value={totalWeeks} onChange={e => setTotalWeeks(parseInt(e.target.value))}>
                        <option value={2}>2 semanas</option>
                        <option value={3}>3 semanas</option>
                        <option value={4}>4 semanas</option>
                        <option value={6}>6 semanas</option>
                        <option value={8}>8 semanas</option>
                        <option value={10}>10 semanas</option>
                        <option value={12}>12 semanas</option>
                    </select>
                </div>

                <button className="modal-btn" onClick={handleCreate} disabled={loading}>
                    {loading ? 'Creando...' : 'Crear club'}
                </button>
            </div>
        </div>
    )
}

export default CreateClubModal