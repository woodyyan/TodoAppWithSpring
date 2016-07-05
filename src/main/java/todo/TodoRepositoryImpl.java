package todo;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sbyan on 6/20/16.
 */
public class TodoRepositoryImpl implements TodoRepository {

    static Map<String, TodoItem> todos = new HashMap();
    private final AtomicLong counter = new AtomicLong();

    public TodoRepositoryImpl() {
        TodoItem item = new TodoItem();
        item.setKey(Long.toString(counter.incrementAndGet()));
        item.setName("First todo");
        add(item);
    }

    @Override
    public void add(TodoItem item) {
        item.setKey(Long.toString(counter.incrementAndGet()));
        todos.put(item.getKey(), item);
    }

    @Override
    public Collection<TodoItem> getAll() {
        return todos.values();
    }

    @Override
    public TodoItem find(String key) {
        TodoItem item = todos.get(key);
        return item;
    }

    @Override
    public TodoItem remove(String key) {
        TodoItem item = todos.remove(key);
        return item;
    }

    @Override
    public void update(TodoItem item) {
        todos.put(item.getKey(), item);
    }
}