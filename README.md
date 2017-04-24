# VSPER
VSPER software architecture to have different components and each component will have single responsibility


## Main Components of Modified MVP (VSPER)

The main parts of VSPER are:

<b>View:</b> displays what it is told to by the Presenter and relays user input back to the Presenter.</br>
<b>Presenter:</b> contains business logic for preparing content for display and for reacting to user inputs (by requesting new data from the repository).</br>
<b>Repository:</b> is responsible for getting the new data either from cache or from network whichever is available/needed.</br>
<b>Entity:</b> contains basic model objects used by the Repository.</br>
<b>Service:</b> responsible for fetching the data from the network.</br>
<b>View Model:</b> This optional component is only needed when there is different kind of data that presenter needs to give it to the View and instead of passing bunch of things to different methods, you can put these different data inside this View Model container class and pass it to the View.</br>
