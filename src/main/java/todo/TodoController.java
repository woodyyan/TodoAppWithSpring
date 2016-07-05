package todo;

import com.sun.tools.javac.comp.Todo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;

/**
 * Created by sbyan on 6/20/16.
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoRepository todoItems;

    public TodoController() {
        todoItems = new TodoRepositoryImpl();
    }

    @RequestMapping("/all")
    public Collection<TodoItem> getAllTodos() {
        return todoItems.getAll();
    }

    @RequestMapping("/{key}")
    public TodoItem getByKey(@PathVariable("key") String key) {

        TodoItem item = todoItems.find(key);
        return item;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String create(@RequestBody TodoItem item) {
        todoItems.add(item);
        return "Create succussful!";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{key}")
    public String update(@PathVariable("key") String key, @RequestBody TodoItem item) {
        if (item == null || !item.getKey().equals(key))
        {
            return "error";
        }

        TodoItem todo = todoItems.find(key);
        todoItems.update(item);
        return "update succussful";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{key}")
    public String delete(@PathVariable("key") String key) {
        todoItems.remove(key);
        return "delete succussful";
    }

//    public static void main(String[] args) {
//        SpringApplication.run(TodoController.class);
//    }
}
