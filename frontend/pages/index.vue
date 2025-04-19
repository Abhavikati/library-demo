<template>
  <div>
    <h1 class="text-2xl font-bold mb-4">Book List</h1>

    <ul class="mb-6">
      <li v-for="book in books" :key="book.id" class="mb-2 flex items-center justify-between">
        <span>{{ book.title }} by {{ book.author }}</span>
        <button @click="deleteBookById(book.id)" class="text-red-500 hover:underline">Delete</button>
      </li>
    </ul>

    <form @submit.prevent="addNewBook" class="space-y-2">
      <input v-model="newBook.title" placeholder="Title" class="border px-2 py-1 w-full" required />
      <input v-model="newBook.author" placeholder="Author" class="border px-2 py-1 w-full" required />
      <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded">Add Book</button>
    </form>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted } from 'vue'
import { useBooks } from '~/composables/useBooks'

const { getBooks, deleteBook, addBook } = useBooks()

const books = ref([])
const newBook = reactive({ title: '', author: '' })

const fetchBooks = async () => {
  const { data } = await getBooks()
  books.value = data.value || []
}

const deleteBookById = async (id: number) => {
  await deleteBook(id)
  fetchBooks()
}

const addNewBook = async () => {
  await addBook({ ...newBook })
  newBook.title = ''
  newBook.author = ''
  fetchBooks()
}

onMounted(() => {
  fetchBooks()
})
</script>


