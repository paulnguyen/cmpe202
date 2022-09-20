
class ClassZ {

	private String mail ; // public attribute via setters and getters
    private String shout ;
    protected String foo ;
    protected String bar ;
    String test ; // package scope

	public String getMail() {
		return this.mail ;
	}

	public void setMail( String msg ) {
		this.mail = msg ;
	}

    public void testPublicMethod() {
        // do test...
    }
}
