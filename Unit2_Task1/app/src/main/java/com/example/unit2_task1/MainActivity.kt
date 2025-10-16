import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    // Утилиты для читаемости
    private fun isTvOn() = smartTvDevice.deviceStatus == "on"
    private fun isLightOn() = smartLightDevice.deviceStatus == "on"

    // Включение/выключение учитывают переход состояния (off -> on / on -> off)
    fun turnOnTv() {
        val wasOn = isTvOn()
        if (!wasOn) {
            smartTvDevice.turnOn()
            deviceTurnOnCount++
        } else {
            println("TV is already on.")
        }
    }

    fun turnOffTv() {
        val wasOn = isTvOn()
        if (wasOn) {
            smartTvDevice.turnOff()
            deviceTurnOnCount--
        } else {
            println("TV is already off.")
        }
    }

    fun turnOnLight() {
        val wasOn = isLightOn()
        if (!wasOn) {
            smartLightDevice.turnOn()
            deviceTurnOnCount++
        } else {
            println("Light is already on.")
        }
    }

    fun turnOffLight() {
        val wasOn = isLightOn()
        if (wasOn) {
            smartLightDevice.turnOff()
            deviceTurnOnCount--
        } else {
            println("Light is already off.")
        }
    }

    // Действия ТОЛЬКО если устройство включено
    fun increaseTvVolume() {
        if (isTvOn()) smartTvDevice.increaseSpeakerVolume()
        else println("Cannot change TV volume: TV is off.")
    }

    fun decreaseTvVolume() {
        if (isTvOn()) smartTvDevice.decreaseVolume()
        else println("Cannot change TV volume: TV is off.")
    }

    fun changeTvChannelToNext() {
        if (isTvOn()) smartTvDevice.nextChannel()
        else println("Cannot change TV channel: TV is off.")
    }

    fun changeTvChannelToPrevious() {
        if (isTvOn()) smartTvDevice.previousChannel()
        else println("Cannot change TV channel: TV is off.")
    }

    fun increaseLightBrightness() {
        if (isLightOn()) smartLightDevice.increaseBrightness()
        else println("Cannot change light brightness: Light is off.")
    }

    fun decreaseLightBrightness() {
        if (isLightOn()) smartLightDevice.decreaseBrightness()
        else println("Cannot change light brightness: Light is off.")
    }

    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    fun turnOffAllDevices() {
        // используем уже корректные методы, которые учитывают переход состояния
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    private var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
        // если значение вне диапазона — просто игнорируем присвоение
    }
}

fun main() {
    val tv = SmartTvDevice("Android TV", "Entertainment")
    val light = SmartLightDevice("Google Light", "Utility")
    val home = SmartHome(tv, light)

    // Включаем устройства (deviceTurnOnCount должен увеличиваться корректно)
    home.turnOnTv()
    home.turnOnLight()
    println("Devices ON: ${home.deviceTurnOnCount}")

    // Печать инфо по устройствам
    home.printSmartTvInfo()
    home.printSmartLightInfo()

    // Действия, разрешённые только при включённых устройствах
    home.increaseTvVolume()
    home.decreaseTvVolume()
    home.changeTvChannelToNext()
    home.changeTvChannelToPrevious()

    home.increaseLightBrightness()
    home.decreaseLightBrightness()

    // Попробуем выполнить действия после выключения — должны заблокироваться
    home.turnOffAllDevices()
    println("Devices ON: ${home.deviceTurnOnCount}")

    home.increaseTvVolume()           // должно сообщить, что TV выключен
    home.decreaseLightBrightness()    // должно сообщить, что Light выключен
}
