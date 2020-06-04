package renen.project.waterapp.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.events.calendar.views.EventsCalendar
import kotlinx.android.synthetic.main.fragment_history.*
import renen.project.waterapp.R
import java.util.*

class HistoryFragment : Fragment(), EventsCalendar.Callback  {

    val adapter = HistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgBack.setOnClickListener {
            findNavController().popBackStack()
        }

        rvHistory.layoutManager = LinearLayoutManager(requireContext())

        val list = arrayListOf<HistoryAdapterEntity>(
            HistoryAdapterEntity(R.drawable.ic_cup_water, "Вода", "250 мл", "14:30"),
            HistoryAdapterEntity(R.drawable.ic_cup_coffee, "Кофе", "300 мл", "14:30"),
            HistoryAdapterEntity(R.drawable.ic_cup_water, "Вода", "250 мл", "14:30"),
            HistoryAdapterEntity(R.drawable.ic_cup_coffee, "Кофе", "350 мл", "14:30")
        )
        adapter.setList(list)
        rvHistory.adapter = adapter

        val today = Calendar.getInstance()
        val lastYearToday = Calendar.getInstance()
        lastYearToday.set(2018, 3, 23)
        val futureYearToday = Calendar.getInstance()
        futureYearToday.set(2020, 8, 23)

        val typeface = ResourcesCompat.getFont(requireContext(), R.font.lato)

        typeface?.let { tf ->
            eventsCalendar.setSelectionMode(eventsCalendar.SINGLE_SELECTION) //set mode of Calendar
                .setToday(today) //set today's date [today: Calendar]
                .setMonthRange(
                    lastYearToday,
                    futureYearToday
                ) //set starting month [start: Calendar] and ending month [end: Calendar]
                .setWeekStartDay(
                    Calendar.MONDAY,
                    false
                ) //set start day of the week as you wish [startday: Int, doReset: Boolean]
                .setCurrentSelectedDate(today) //set current date and scrolls the calendar to the corresponding month of the selected date [today: Calendar]
                .setDatesTypeface(tf) //set font for dates
                .setDateTextFontSize(16f) //set font size for dates
                .setMonthTitleTypeface(tf) //set font for title of the calendar
                .setMonthTitleFontSize(16f) //set font size for title of the calendar
                .setWeekHeaderTypeface(tf) //set font for week names
                .setWeekHeaderFontSize(16f) //set font size for week names
                .setCallback(this) //set the callback for EventsCalendar
                .setSelectionColor(ContextCompat.getColor(requireContext(), R.color.green))
            eventsCalendar
                .setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            eventsCalendar.build()
        }
    }

    override fun onDayLongPressed(selectedDate: Calendar?) {

    }

    override fun onDaySelected(selectedDate: Calendar?) {

    }

    override fun onMonthChanged(monthStartDate: Calendar?) {

    }
}