package com.example.test;

import com.example.test.model.Model;
import com.example.test.model.entity.Clicker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ModelTest {

    @Test
    public void incrementCounter_shouldIncrementNumber() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, "0");

        // Act
        Clicker result = model.incrementCounter(clicker);

        // Assert
        assertEquals("1", result.getCounter());
    }

    @Test
    public void incrementCounter_shouldResetNumberIfMaxValueReached() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, String.valueOf(Integer.MAX_VALUE));

        // Act
        Clicker result = model.incrementCounter(clicker);

        // Assert
        assertEquals("0", result.getCounter());
    }

    @Test
    public void WriteCharacterInTextFieldN1() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, " Hello Gerasimov Alexander");

        // Act
        Integer result = model.convertStringToInteger(clicker);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void WriteCharacterInTextFieldN2() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, "How are you");

        // Act
        Integer result = model.convertStringToInteger(clicker);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void IncrementNumberAndTrashN1() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, "31231dfasfasf");

        // Act
        Clicker result = model.incrementCounter(clicker);

        // Assert
        assertEquals("1", result.getCounter());
    }

    @Test
    public void IncrementNumberAndTrashN2() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, "dsgasdfas21312");

        // Act
        Clicker result = model.incrementCounter(clicker);

        // Assert
        assertEquals("1", result.getCounter());
    }

    @Test
    public void convertStringToInteger_shouldConvertValidStringToNumber() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, "123");

        // Act
        Integer result = model.convertStringToInteger(clicker);

        // Assert
        assertEquals(123, result);
    }

    @Test
    public void convertStringToInteger_shouldReturnZeroForInvalidString() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, "abc");

        // Act
        Integer result = model.convertStringToInteger(clicker);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void checkedMaxIntegerValue() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, String.valueOf(Integer.MAX_VALUE));

        // Act
        Integer result = model.convertStringToInteger(clicker);

        // Assert
        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void checkedMinIntegerValue() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, String.valueOf(Integer.MIN_VALUE));

        // Act
        Integer result = model.convertStringToInteger(clicker);

        // Assert
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    public void checkedIncrementMaxIntegerValue() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, String.valueOf(Integer.MAX_VALUE));

        // Act
        clicker = model.incrementCounter(clicker);
        Integer result = model.convertStringToInteger(clicker);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void checkedIncrementMinIntegerValue() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, String.valueOf(Integer.MIN_VALUE));

        // Act
        clicker = model.incrementCounter(clicker);
        Integer result = model.convertStringToInteger(clicker);

        // Assert
        assertEquals(Integer.MIN_VALUE + 1, result);
    }

    @Test
    public void checkedIncrementLongIntegerValue() {
        // Arrange
        Model model = new Model(null);
        Clicker clicker = new Clicker(1, "456789567896545678986556");

        // Act
        Integer result = model.convertStringToInteger(clicker);

        // Assert
        assertEquals(0, result);
    }

}
