package ca.rmen.detektindentationissue

import kotlin.random.Random

class Hello {
    fun randomBoolean(): Boolean {

        return Random.nextBoolean() || Random.nextBoolean() &&
                Random.nextBoolean() || Random.nextBoolean() && Random.nextBoolean() && Random.nextBoolean() ||
                Random.nextBoolean()
    }
}
