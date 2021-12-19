# Example for issue CAM-14187
This project is an example of how to extend history event handling:
* A custom history event is created in the method `CustomActivityInstanceStartListener#createCustomHistoryEvent`.
As an example, a business key is added to the event, but any logic can be there
* An execution listener is registered in the class In `CustomHistoryParseListener`
* `CustomHistoryEventHandler` is a handler that is handled custom history event