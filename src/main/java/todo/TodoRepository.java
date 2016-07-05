package todo;

import java.util.Collection;
import java.util.List;

/**
 * Created by sbyan on 6/20/16.
 */
public interface TodoRepository
{
    void add(TodoItem item);
    Collection<TodoItem> getAll();
    TodoItem find(String key);
    TodoItem remove(String key);
    void update(TodoItem item);
}