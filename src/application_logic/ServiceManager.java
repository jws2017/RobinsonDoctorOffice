package application_logic;

public interface ServiceManager<T> {

	boolean receive(Node<T> requestor, T request, RequestType requestType);
	boolean respond();

}
