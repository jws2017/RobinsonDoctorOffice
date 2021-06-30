package interfaces;

import java.util.ArrayList;

/**
 * Created by Galileo on 03/26/2017.
 */
public interface CRUDManager<T extends Object>{


    /**
     * Generic create method facilitates the adding of an object to the list
     *
     * @param object is the object to be added to list.
     */
    public void add(T object);
    

    /**
     * Generic create method facilitates searching for an object by name.
     *
     * @param name matches against name or corresponding attribute of object
     *
     * @return object found or null.
     */
    public T findByName(String name);
    

    /**
     * Generic create method facilitates searching for an object by id.
     *
     * @param id matches against id or corresponding attribute of object
     *
     * @return object found or null.
     */
    public T findById(String id);
    

    /**
     * Generic search method. Keyword search facilitates finding all objects whose attributes contain the entered keyword..
     *
     * @param searchStr matches against string attributes of all objects in list of objects.
     *
     * @return list of objects found where attributes contains search string
     */
    public ArrayList<T> search(String searchStr);
    
    
    /**
     * Generic create method facilitates the deleting of an object.
     *
     * @param object the object to be deleted
     */
    public void delete(T object);

    
    /**
     * Generic create method facilitates the updating of an object.
     * @param object the object to be updated
     * @return updated.
     */
    public T update(T object);
}
