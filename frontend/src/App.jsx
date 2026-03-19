import BookSearch from './components/BookSearch'
import './App.css'

function App() {
    return (
        <div className="app">
            <div className="app-header">
                <h1>Book Club</h1>
                <p>Encuentra tu próxima lectura</p>
            </div>
            <BookSearch />
        </div>
    )
}

export default App