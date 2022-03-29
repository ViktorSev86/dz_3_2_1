import kotlin.collections.Collection as Collection

fun main() {

}

class NoteNotFoundException(message: String) : RuntimeException(message)


object WallService {
    private var notes: MutableList<Note> = ArrayList<Note>()
    private var comments: MutableList<Comment> = ArrayList<Comment>()

    fun add(note: Note): Note {
        if (!notes.isEmpty()) {
            val oldId = notes.last().id
            val newId = oldId + 1
            notes += note.copy(newId)
        } else {
            notes += note.copy(1)
        }
        return notes.last()
    }

    fun delete(id: Int): Boolean {
        var ind = 0;
        for (n in notes) {
            if (id == n.id) {
                notes.removeAt(ind)
                return true
            }
            ind++
        }
        return false
    }

    fun edit(note: Note): Boolean {
        val id = note.id;
        for ((index, oldPost) in notes.withIndex()) {
            if (id == oldPost.id) {
                val tempPost = oldPost
                notes[index] = note.copy(date = oldPost.date);
                return true
            }
        }
        return false
    }

    fun getById(id: Int): Note {
        for ((index, note) in notes.withIndex()) {
            if (id == note.id) {
                return notes[index]
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует")
    }

    fun get(): List<Note> {
        return notes
    }

    fun createComment(noteId: Int, comment: Comment):Comment {
        for (n in notes) {
            if (noteId == n.id) {
                if (!comments.isEmpty()) {
                    val oldCommentId = comments.last().commentId
                    val commentCopy = comment.copy(commentId = oldCommentId + 1)
                    comments += commentCopy
                    n.countComments++
                    return commentCopy
                } else {
                    val commentCopy = comment.copy(commentId = 1)
                    comments += commentCopy
                    n.countComments = 1
                    return commentCopy
                }
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует")
    }

    fun deleteComment(noteId: Int, commentId: Int): Boolean {
        for (n in notes) {
            if (noteId == n.id) {
                if (!comments.isEmpty()) {
                    for (c in comments) {
                        if (commentId == c.commentId) {
                            c.isDelete = true
                            n.countComments--
                            return true
                        }
                    }
                }
            }
        }
        return false
    }

    fun editComment(noteId: Int, comment: Comment): Boolean {
        for (n in notes) {
            if (noteId == n.id) {
                if (!comments.isEmpty()) {
                    for (c in comments) {
                        if (comment.commentId == c.commentId) {
                            if (c.isDelete == true) {
                                println("Нельзя редактировать удалённый комментарий. Сначала восстановите его.")
                                return false
                            }
                            comments.remove(c)
                            comments += comment
                            return true
                        }
                    }
                }
            }
        }
        return false
    }

    fun restoreComment(noteId: Int, commentId: Int): Boolean {
        for (n in notes) {
            if (noteId == n.id) {
                if (!comments.isEmpty()) {
                    for (c in comments) {
                        if (commentId == c.commentId && c.isDelete == true) {
                            c.isDelete = false
                            n.countComments++
                            return true
                        }
                    }
                }
            }
        }
        return false
    }
}


data class Note(
    val id: Int,
    //val ownerId: Int,   не используем
    val title: String,
    val text: String,
    val date: Int,
    var countComments: Int,
    var countRedComments: Int
    //val viewUrl: String   не используем
)

data class Comment(
    //val ownerId: Int,   не используем
    val commentId: Int = 0,
    val noteId: Int,
    val fromGroup: Int = 0,
    val message: String?,
    val replyToComment: Int,
    var isDelete: Boolean = false
    //val attachments: Array<Attachment>?,   не используем
    //val sticker_id: UInt,   не используем
    //val guid: int   не используем
)