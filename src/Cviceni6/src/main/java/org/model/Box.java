package org.model;

public class Box<T> {
    // Pouze vlastni nazev
    // Generická třída Box je užitečná ve scénářích, kde chcete mít třídu,
    // která může být použita s různými typy, aniž byste museli vytvářet
    // specifickou třídu pro každý typ, který chcete obalit.
    private T t;

    public void set (T t)
    {
        this.t=t;
    }

    public T get()
    {
        return t;
    }

}

