package MedicalDatabase;

import javax.management.RuntimeErrorException;

public class LList{
	LNode head;
	LNode tail;
	LNode curr;
	int size;
	
	LList()
	{
		head= null;
		tail = null;
	}
	
	public void add(Patient p)
	{
		if(head == null)
		{
			head = new LNode(p);
			tail = head;
			head.next = tail;
			size = 1;
		}
		
		else
		{
			tail.next = new LNode(p);
			tail = tail.next;
			size++;
		}
	}
	
	public void delete(String ID)
	{
		if(head == null)
			throw new RuntimeException("List is empty");
		
		
		curr = head;
		if(curr.getData().GetID().equals(ID) && head.next == null)
		{
			head = null;
		}
		
		
			
			while(curr!=null)
			{	//checks to see if the head is what needs to be delete. changes head to next node
				if(curr.next != null)
				{	
					if(curr.getData().GetID().equals(ID))
					{
						head = curr.next;
						size--;
					
					}
					
					//check to see if the next node has matching ID
					if(curr.next.getData().GetID().equals(ID))
					{
						//checks if the tail is what has the matching id. since tail is next new tail is curr
						if(curr.next == tail)
						{
							tail = curr;
							size--;
						}
						if(curr.next == tail)
						{
							tail = curr.next;
							size--;
						}
						//if not the tail then curr will skip next node and link to node after that
						else
							curr.next = curr.next.next;
						
					}
					
				}
				curr = curr.next;
			}
			
	}

	public LNode find(String ID)
	{
		if(head==null)
		{
			//throw new RuntimeException("Empty List");
		}
		
		curr = head;
		while(curr != null)
		{
			if(curr.getData().GetID().equals(ID))
				return curr;
			
			curr = curr.next;
		}
		
		return null;
	}

	public int size()
	{
		return size;
	}

	public void reset()
	{
		head = null;
	}
}
	
	

