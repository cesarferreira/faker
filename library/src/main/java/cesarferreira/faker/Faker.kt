package cesarferreira.faker

class Faker {
    companion object {
        private fun valueWithSalt(value: Int) = value + (0..20).random()
        fun getRandomImage(width: Int, height: Int) = "https://picsum.photos/${valueWithSalt(width)}/${valueWithSalt(height)}"
    }
}
