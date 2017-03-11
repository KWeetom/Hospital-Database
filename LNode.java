package MedicalDatabase;

public class LNode {
	
	LNode next;
	Patient p;
	LNode previous;
	
	public LNode(  )
	{
		
	}
	
	public LNode(Patient p, LNode link)
	{
		this.next = link;
		this.p = p;
	}
	
	public LNode(Patient p)
	{
		next = null;
		this.p = p;
	}
	
	public LNode getNext()
	{
		return next;
	}
	
	public Patient getData()
	{
		return p;
	}
	
	public void setNext(LNode nextz)
	{
		next= nextz;
	}
	public void setData(Patient data)
	{
		p = data;
	}
	
}
