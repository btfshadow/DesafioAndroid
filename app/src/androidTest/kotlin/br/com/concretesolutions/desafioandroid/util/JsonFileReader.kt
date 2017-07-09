package br.com.concretesolutions.desafioandroid.util

import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

/**
 * This class is used to read json files under the resources/fixtures folder
 *
 * You must put your files there, otherwise this class won't be able to read the files.
 *
 * This was extracted from RequestMatcher lib, so you don't need a RequestMatcherRule instance
 * just to read a json file.
 */
class JsonFileReader {

    companion object {
        private val fixturesRootFolder: String = "fixtures"

        fun readFixture(fixturePath: String): String {
            try {
                return read(open(fixturesRootFolder + "/" + fixturePath)) + "\n"
            } catch (e: IOException) {
                throw RuntimeException("Failed to read asset with path " + fixturePath, e)
            }

        }

        private fun read(`is`: InputStream?): String {

            if (`is` == null) {
                throw IllegalArgumentException("Could not open resource stream.")
            }

            val bis = BufferedReader(InputStreamReader(`is`))
            val builder = StringBuilder()

            var line: String?
            try {
                while (true) {
                    line = bis.readLine() ?: break
                    builder.append(line)
                }
            } catch (e: IOException) {
                throw RuntimeException("Could not read resource fully", e)
            } finally {

                try {
                    `is`.close()
                } catch (e: IOException) {
                    Log.e(JsonFileReader::class.java.simpleName, "Error while trying to close stream", e)
                    // do nothing here
                }

            }

            return builder.append("\n").toString()
        }

        @Throws(IOException::class)
        private fun open(path: String): InputStream {
            return JsonFileReader::class.java.classLoader.getResourceAsStream(path)
        }
    }

}