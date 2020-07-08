package renen.project.waterapp.logic

object WaterIntakeCalculater {
    /**
     * Функция рассчета нормы воды.
     * @param weight Вес пользователя.
     * @param training Флаг, была тенировка или нет.
     * @param activityType Ежедневный уровень активности пользователя.
     * @return Норма воды в миллилитрах.
     */
    fun calculate(weight: Float, training: Boolean, activityType: UserActivityType): Int {
        // Вес * 30 мл
        var ml: Int = (weight * 30).toInt()
        /*
        LOW - низкая активность (сидячий образ жизни: 1 кг * 30 мл).
        MEDIUM - средняя активность (умеренно активная работа: 1 кг * 30 мл 200 мл).
        HIGHT - высокая активность (активная работа: 1 кг * 30 мл + 500 мл).
         */
        ml += when (activityType) {
            UserActivityType.LOW -> 0
            UserActivityType.MEDIUM -> 200
            UserActivityType.HIGHT -> 500
        }
        // Если пользователь тренировался, то к ежедневной норме + 500 мл.
        if (training) {
            ml += 500
        }
        // Округление в большую сторону, например, норма по формуле = 2340, то окгруляем до 2400.
        val round: Boolean = ml % 100 > 0
        ml = ml / 100 * 100
        if (round) {
            ml += 100
        }
        return ml
    }

    enum class UserActivityType {
        LOW, MEDIUM, HIGHT
    }
}