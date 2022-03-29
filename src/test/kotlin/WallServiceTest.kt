import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import junit.framework.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)
    }

    @Test

    fun deleteTrue() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)
        assertTrue(service.delete(1))
    }

    @Test
    fun deleteFalse() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)
        assertFalse(service.delete(100))
    }

    @Test
    fun editTrue() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)
        assertTrue(service.edit(Note(2, "Вторая заметка", "Здесь находится описание второй заметки",
            14032022, 0, 0)))
    }

    @Test
    fun editFalse() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)

        assertFalse(service.edit(Note(100, "Вторая заметка", "Здесь находится описание второй заметки",
            14032022, 0, 0)))
    }

    @Test
    fun getById() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)
        service.getById(2)
    }

    @Test(expected = NoteNotFoundException::class)
    fun getByIdThrow() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)
        service.getById(100)
    }

    @Test
    fun get() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)

        service.get()
    }

    @Test
    fun createComment() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        val comment1: Comment = Comment(0, 1, 0, "Хорошая заметка",
            0, false)
        val comment2: Comment = Comment(0, 1111, 0, "Хорошая заметка",
            0, false)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)
        service.createComment(2, comment1)
    }

    @Test(expected = NoteNotFoundException::class)
    fun createCommentThrowNote() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        val comment1: Comment = Comment(0, 1, 0, "Хорошая заметка",
            0, false)
        val comment2: Comment = Comment(0, 1111, 0, "Хорошая заметка",
            0, false)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)
        service.createComment(100, comment1)
    }

    @Test
    fun deleteCommentTrue() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        val comment1: Comment = Comment(0, 1, 0, "Хорошая заметка",
            0, false)
        val comment2: Comment = Comment(0, 1111, 0, "Хорошая заметка",
            0, false)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)

        service.createComment(2, comment1)

        assertTrue(service.deleteComment(2, 1))
    }

    @Test
    fun deleteCommentFalseNote() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        val comment1: Comment = Comment(0, 1, 0, "Хорошая заметка",
            0, false)
        val comment2: Comment = Comment(0, 1111, 0, "Хорошая заметка",
            0, false)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)

        service.createComment(2, comment1)

        assertFalse(service.deleteComment(100, 1))
    }

    @Test
    fun deleteCommentFalseComment() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        val comment1: Comment = Comment(0, 1, 0, "Хорошая заметка",
            0, false)
        val comment2: Comment = Comment(0, 1111, 0, "Хорошая заметка",
            0, false)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)

        service.createComment(2, comment1)

        assertFalse(service.deleteComment(2, 100))
    }

    @Test
    fun editCommentTrue() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        val comment1: Comment = Comment(0, 1, 0, "Хорошая заметка",
            0, false)
        val comment2: Comment = Comment(0, 1111, 0, "Хорошая заметка",
            0, false)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)

        service.createComment(2, comment1)
        service.createComment(2, comment2)
        assertTrue(service.editComment(2, comment1.copy(commentId = 2)))
    }

    @Test
    fun editCommentFalseNote() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        val comment1: Comment = Comment(0, 1, 0, "Хорошая заметка",
            0, false)
        val comment2: Comment = Comment(0, 1111, 0, "Хорошая заметка",
            0, false)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)

        service.createComment(2, comment1)

        assertFalse(service.editComment(100, comment1))
    }

    @Test
    fun editCommentFalseComment() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        val comment1: Comment = Comment(0, 1, 0, "Хорошая заметка",
            0, false)
        val comment2: Comment = Comment(0, 1111, 0, "Хорошая заметка",
            0, false)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)

        service.createComment(2, comment1)

        assertFalse(service.editComment(2, comment1.copy(commentId = 100)))
    }

    @Test
    fun restoreCommentTrue() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        val comment1: Comment = Comment(0, 1, 0, "Хорошая заметка",
            0, false)
        val comment2: Comment = Comment(0, 1111, 0, "Хорошая заметка",
            0, false)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)

        service.createComment(2, comment1)
        service.deleteComment(2, 1)

        assertTrue(service.restoreComment(2, 1))
    }

    @Test
    fun restoreCommentFalseNote() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        val comment1: Comment = Comment(0, 1, 0, "Хорошая заметка",
            0, false)
        val comment2: Comment = Comment(0, 1111, 0, "Хорошая заметка",
            0, false)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)

        service.createComment(2, comment1)

        assertFalse(service.restoreComment(100, 1))
    }

    @Test
    fun restoreCommentFalseNoDeleted() {
        val note1: Note = Note(0, "Главная заметка", "Здесь находится описание заметки",
            12032022, 0, 0)
        val note2: Note = Note(0, "Вторая заметка", "Здесь находится описание второй заметки",
            12032022, 0, 0)

        val comment1: Comment = Comment(0, 1, 0, "Хорошая заметка",
            0, false)
        val comment2: Comment = Comment(0, 1111, 0, "Хорошая заметка",
            0, false)

        var notes: MutableList<Note> = ArrayList<Note>()
        var comments: MutableList<Comment> = ArrayList<Comment>()

        val service = WallService
        service.add(note1)
        service.add(note2)

        service.createComment(2, comment1)
        service.createComment(2, comment2)

        assertFalse(service.restoreComment(2, 2))
    }

}