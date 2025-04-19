export const useBooks = () => {
  const config = useRuntimeConfig()
  const baseURL = `${config.public.apiBase}/api/books`

  const getBooks = async () => {
    console.log('Fetching books from:', baseURL) // Add this log
    const { data, error, refresh } = await useFetch(baseURL)
    console.log('Response data:', data) // Add this log
    return { data, error, refresh }
  }

const addBook = async (book: { title: string; author: string }) => {
  const response = await fetch(baseURL, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(book)
  })
  const data = await response.json()
  return { data }
}

const deleteBook = async (id: number) => {
  const response = await fetch(`${baseURL}/${id}`, {
    method: 'DELETE'
  })
  return { success: response.ok }
}

  return { getBooks, deleteBook, addBook }
}
