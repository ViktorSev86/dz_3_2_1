# Заметки


Поля, которые исключили проекта с целью упрощения:

Для класса Note:
* val ownerId: Int,
* val viewUrl: String

Для класса Comment:
* val ownerId: Int,
* val attachments: Array<Attachment>,
* al sticker_id: UInt,
* val guid: int   не используем

Для возвратного псевдоудаления комментариев в класс Comment введена переменная var isDelete: Boolean = false.