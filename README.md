# VSPER
VSPER software architecture to have different components and each component will have single responsibility. Inspired from MVP framework, VIPER architecture and Google ToDo Android architecture app.


## Main Components of Modified MVP (VSPER)

The main parts of VSPER are:

<b>View:</b> displays what it is told to by the Presenter and relays user input back to the Presenter.</br>
<b>Presenter:</b> contains business logic for preparing content for display and for reacting to user inputs (by requesting new data from the repository).</br>
<b>Repository:</b> is responsible for getting the new data either from cache or from network whichever is available/needed.</br>
<b>Entity:</b> contains basic model objects used by the Repository.</br>
<b>Service:</b> responsible for fetching the data from the network.</br>
<b>View Model:</b> This optional component is only needed when there is different kind of data that presenter needs to give it to the View and instead of passing bunch of things to different methods, you can put these different data inside this View Model container class and pass it to the View.</br>

## Goals
- Having a single responsibility component architecture makes the development of feature easy and reliable since you don't have to change all the components in most cases.</br>
- It makes the code more testable and flexible.</br>
- The architecture also helps in code sharing among other features.</br>
- Each piece can perform its functionality with not much of external dependencies and if there are dependencies, it should be injected.</br>

## Diagram
![](https://github.com/vaibhavsh82/VSPER/blob/master/VSPER.png)

## FAQs
Q: Who is responsible for updating the in-memory cache when we get the data from network?</br>
Repository is. All the data model/entity related things should be handled by repository to avoid communication between network layer and caching or presenter and caching.</br>

Q: What happens to the view on config change?</br>
If it is an activity, it will be recreated. Fragment has inherent capability of handling the config change by using the FragmentManager so we should use that. If View requested a data before config change then there could be two situations:</br>
- The network request is already done and the requested data is already saved to in-memory cache and we need not to worry about View -> Presenter-> Repository recreation.</br>
- If network request is ongoing and View recreated before the response then either you have to persist the Presenter so that you can your presenter is still listening to repository which in turns listening for network request and not this lost. One way to persist the Presenter is using Fragment and making it retainable by setRetainable(true) method. Other way is to store the presenter to application object before config change and retrieve it after. Make sure you clear the application after retrieval.</br>

Q: How View gets the data from Presenter?</br>
Presenter listens to data from repository using callbacks and when data is available, Presenter uses EventBus / RxJava Observer to send data to view. Views are listening to data using usual onEventMainThread(Event event) method or observing it using RxJava observable.</br>

Q: How Repository tells Presenter the data is available?</br>
A Presenter passed a callback to repository that repository uses to respond.</br>

Q: How WebService/Service return response to Repository?</br>
Again callbacks but make sure it is new callback and not the callback repository got from presenter. The rationale is that we don't direct communication between Service and Presenter since the callback is same plus repository needs to update the cache when network response is returned, with presenter callback being passed directly it is hard to listen to it in middle and presenter's responsibility is not to update the cache. Presenter should never have reference/access to in-memory cache ever.</br>
