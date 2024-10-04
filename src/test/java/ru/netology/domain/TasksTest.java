package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask task = new SimpleTask(1, "Посмотреть календарь");

        boolean expected = true;
        boolean actual = task.matches("Посмотреть");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchSimpleTask() {
        SimpleTask task = new SimpleTask(1, "Посмотреть календарь");

        boolean expected = false;
        boolean actual = task.matches("Заполнить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchEpicTask() {
        String[] subtasks = {"Написать список", "Пойти в магазин"};
        Epic epic = new Epic(2, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("список");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchEpicTask() {
        String[] subtasks = {"Написать список", "Пойти в магазин"};
        Epic epic = new Epic(2, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("прогулка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchMeetingTopic() {
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Альфа", "Завтра в 10 утра");

        boolean expected = true;
        boolean actual = meeting.matches("Обсуждение");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchMeetingProject() {
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Альфа", "Завтра в 10 утра");

        boolean expected = true;
        boolean actual = meeting.matches("Альфа");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotMatchMeeting() {
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Альфа", "Завтра в 10 утра");

        boolean expected = false;
        boolean actual = meeting.matches("Бета");

        Assertions.assertEquals(expected, actual);

    }
}




