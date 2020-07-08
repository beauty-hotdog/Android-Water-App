package renen.project.waterapp

import org.junit.Assert
import org.junit.Test
import renen.project.waterapp.logic.WaterIntakeCalculater
import renen.project.waterapp.util.isLastElement

class WaterIntakeCalculaterTest {
    @Test
    fun calculater_test(){
        Assert.assertEquals(2400, WaterIntakeCalculater.calculate(62f, false, WaterIntakeCalculater.UserActivityType.HIGHT))
    }
}