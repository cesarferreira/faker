package cesarferreira.faker

import java.util.*

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start