package cesarferreira.faker

import java.util.Random

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start
