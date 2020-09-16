package net.daan.odontoapp.http

import okhttp3.*

class HttpHelper(private val email: String = "", private val senha: String = "") {

    private var URL = "http://192.168.0.105:8080/odonto"
    private val headerHttp = MediaType.parse("application/json; charset=utf-8; ")
    private val client = OkHttpClient()

    fun post(endpoint: String, json: String): String {
        val body = RequestBody.create(headerHttp, json)
        val request =   Request.Builder().url(URL + endpoint)
            .addHeader("Authorization", Credentials.basic(email, senha))
            .post(body).build()
        val response = client.newCall(request).execute()
        val responseBody = response.body()!!.string()

        println(">>>>>>>>>>>>>>>>>>>>>>>>> POST: $responseBody")

        return responseBody
    }

    fun put(endpoint: String, json: String): String {
        val body = RequestBody.create(headerHttp, json)
        val request = Request.Builder().url(URL + endpoint)
            .addHeader("Authorization", Credentials.basic(email, senha))
            .put(body).build()
        val response = client.newCall(request).execute()
        val responseBody = response.body()!!.string()

        println(">>>>>>>>>>>>>>>>>>>>>>>>> PUT: $responseBody")

        return responseBody
    }

    fun get(endpoint: String): String {
        val request = Request.Builder().url(URL + endpoint)
            .addHeader("Authorization", Credentials.basic(email, senha))
            .get().build()
        val response = client.newCall(request).execute()
        val responseBody = response.body()!!.string()

        println(">>>>>>>>>>>>>>>>>>>>>>>>> GET: $responseBody")

        return responseBody
    }

    fun setURL(url: String) {
        URL = url
    }
}