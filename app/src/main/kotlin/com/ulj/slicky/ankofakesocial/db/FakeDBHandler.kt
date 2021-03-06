package com.ulj.slicky.ankofakesocial.db

import com.ulj.slicky.ankofakesocial.model.content.Content
import com.ulj.slicky.ankofakesocial.model.person.Person
import com.ulj.slicky.ankofakesocial.rest.ApiServices
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by SlickyPC on 20.5.2017
 */
object FakeDBHandler : DBHandler {

    private val lock = Any()
    private val random = Random()

    private var person: Person? = null
    private var friendList: List<Person>? = null
    private var contentList: List<Content>? = null

    var isSignedIn: Boolean = false
        private set

    @Throws(IOException::class)
    override fun signin(email: String, password: String): Boolean {
        // Simulate network work.
        simulateWork()
        // TODO: This should be changed.
        isSignedIn = email == "change@me.pls" && password == "password"
        return isSignedIn
    }

    override fun signout() {
        // Not simulating work because this should run on async thread.
        /* simulateWork(); */
        // Remove all data assigned to user.
        isSignedIn = false
        person = null
        friendList = null
        contentList = null
    }

    @Throws(IOException::class)
    override fun signup(firstName: String,
                        lastName: String,
                        email: String,
                        password: String): Boolean {
        // Simulate network work.
        simulateWork()
        // TODO: This should be changed.
        isSignedIn = true
        return isSignedIn
    }

    @Throws(IOException::class)
    override fun uploadContent(content: String): Boolean {
        person?.let {
            // Simulate network work.
            simulateWork()
            // Create new Content.
            val newContent = Content(random.nextLong(), it, content, System.currentTimeMillis())
            // Create new Content list with new Content in top.
            contentList = ArrayList<Content>().apply {
                add(newContent)
                addAll(contentList ?: emptyList())
            }
            return true
        }
        return false
    }

    override fun getUser(): Person {
        if (person == null)
            queryData()
        return person ?: throw IOException("Could not receive User!")
    }

    override fun getFriends(): List<Person> {
        if (friendList == null)
            queryData()
        return friendList ?: throw IOException("Could not receive Friends!")
    }

    override fun getContent(): List<Content> {
        if (contentList == null)
            queryData()
        return contentList ?: throw IOException("Could not receive Content!")
    }

    fun removeContent(content: Content) {
        simulateWork()
        contentList = contentList?.minusElement(content)
    }

    @Throws(IOException::class)
    private fun queryData() {
        // In case multiple calls happen.
        synchronized(lock) {
            // Find person candidates.
            val candidates = findCandidates()
            // Use first person as user.
            person = candidates[0]
            // Use rest as friends.
            friendList = candidates.subList(1, candidates.size)
            // Generate contents.
            contentList = generateContent()
        }
    }

    @Throws(IOException::class)
    private fun findCandidates(): List<Person> {
        // Blocking api request for new random persons.
        val query = ApiServices.personApi
                .getPerson(50)
                .execute()
                .body() ?: throw IOException("Did not receive candidates (body is null)")

        // Distinct received persons by image URL.
        val candidates = query.results.distinctBy { it.picture.large }

        if (candidates.isEmpty())
            throw IOException("Did not receive enough candidates (size < 1)")

        return candidates
    }

    @Throws(IOException::class)
    private fun generateContent() = mutableListOf<Content>().also { list ->
        friendList?.let { friends ->

            repeat(10) {

                // Blocking api request for new Content text.
                val query = ApiServices.contentApi
                        .getContent()
                        .execute().body() ?: throw IOException("Did not receive Content (is null)")

                // Pick random Content owner.
                val randy = friends[random.nextInt(friends.size)]

                // Find last post time or set it to currentTimeMillis.
                val lastPostTime = if (list.isNotEmpty())
                    list.last().postedAt
                else
                    System.currentTimeMillis()

                // Assign random delay between posts.
                val timePassed = random.nextInt(1000 * 60 * 60 * 24)

                // Create new Content and add it to list.
                val content = Content(random.nextLong(), randy, query, lastPostTime - timePassed)
                list.add(content)

            }
        }
    }

    private fun simulateWork() {
        TimeUnit.SECONDS.sleep(1)
    }

}
