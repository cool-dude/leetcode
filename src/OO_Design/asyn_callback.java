interface OnEventListener {
    // this can be 
	// any type of method
    void onEvent();
}
class Test implements OnEventListener {
    @Override
    public void onEvent(){
    }
}
class Integration { 
    private OnEventListener 
	mListener; 
	// listener field
    // setting the listener
    public void 
	registerOnEventListener(OnEventListener _mList) {
        this.mListener = 
			_mList;
    }
    // my synchronous task
    public void doStuff() {
        // check if listener 
		// is registered.
        if (this.mListener != null) {
            // invoke the callback 
			// method of class A
            mListener.onEvent();
        }
    }
    // Driver Function
    public static 
	void main(String[] args) {
        Integration obj = 
			new Integration();
        OnEventListener mListener = 
			new Test();
        obj.registerOnEventListener(
		mListener);
        obj.doStuff();
    }
}