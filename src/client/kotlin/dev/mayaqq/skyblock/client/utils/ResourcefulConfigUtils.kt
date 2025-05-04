package dev.mayaqq.skyblock.client.utils

import com.teamresourceful.resourcefulconfig.api.types.elements.ResourcefulConfigSeparatorElement
import com.teamresourceful.resourcefulconfig.api.types.entries.ResourcefulConfigValueEntry
import com.teamresourceful.resourcefulconfig.api.types.options.EntryData
import com.teamresourceful.resourcefulconfig.api.types.options.EntryType
import com.teamresourceful.resourcefulconfig.api.types.options.TranslatableValue

class DynamicSeparator(
    title: String,
    description: String,
    val condition: () -> Boolean = { true },
) : ResourcefulConfigSeparatorElement {
    private val title = Translated(title)
    private val description = Translated(description)

    override fun title() = title
    override fun description() = description
    override fun isHidden(): Boolean = !condition()
}

private fun Translated(key: String) = TranslatableValue("", key)
fun DynamicEntryData(title: String, description: String) = EntryData(Translated(title), Translated(description), mapOf())

interface ResourcefulConfigEnumValueEntry : ResourcefulConfigValueEntry {
    override fun isArray() = false

    override fun getArray() = get() as Array<*>
    override fun setArray(array: Array<out Any?>?) = false

    override fun getByte() = get() as Byte
    override fun setByte(value: Byte) = false

    override fun getShort() = get() as Short
    override fun setShort(value: Short) = false

    override fun getInt() = get() as Int
    override fun setInt(value: Int) = false

    override fun getLong() = get() as Long
    override fun setLong(value: Long) = false

    override fun getFloat() = get() as Float
    override fun setFloat(value: Float) = false

    override fun getDouble() = get() as Double
    override fun setDouble(value: Double) = false

    override fun getBoolean() = get() as Boolean
    override fun setBoolean(value: Boolean) = false

    override fun getString() = get() as String
    override fun setString(value: String?) = false

    override fun getEnum() = get() as Enum<*>

    override fun type() = EntryType.ENUM
}
