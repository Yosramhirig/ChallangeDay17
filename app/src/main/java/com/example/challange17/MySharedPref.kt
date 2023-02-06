import android.content.Context

class MySharedPref(context: Context) {

    companion object {
        private const val FILE_KEY = "user_info"
        private const val File_SIZE = "file_size"
    }

    private val sharedPref = context.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE)


    fun savesize(size: Float){
        sharedPref.edit()
            .putFloat(File_SIZE, size)
            .apply()
    }

    fun getsize(): Float? {
        return sharedPref.getFloat(File_SIZE, 0f)
    }
}