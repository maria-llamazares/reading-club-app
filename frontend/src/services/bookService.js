import axios from 'axios'

const API_URL = 'http://localhost:8080/api'

export const searchBooks = async (query) => {
    const response = await axios.get(`${API_URL}/books/search?q=${query}`)
    return response.data
}