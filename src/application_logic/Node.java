package application_logic;

public interface Node<T> {

	void sendRequest(ServiceManager<T> manager, T request, RequestType requestType);

}
