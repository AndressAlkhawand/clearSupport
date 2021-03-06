package Users;
import java.io.Serializable;
import Tickets.Ticket;

/**
	Technician Class
	Extends the Employee class.
	@author Andress Alkhawand - Hubert Whan Tong
 */

public class Technician extends Employee implements Serializable
{
	private int superID; //ID of supervisor, not of technician
	private boolean isActive;
	private boolean isSupervisor; 	
	private static final long serialVersionUID = 2L;  //Required for serialization
	public static final String DEPARTMENT = "Help Desk";

	/**
	 * Default constructor.  Department is set to Help Desk.
	 * @param id Employee ID number.
	 * @param first First name.
	 * @param last Last name. 
	 * @param hireD Employee's hire date.
	 * @param phone Phone number.
	 * @param email Email address.
	 * @param supervisor ID number of the supervisor.
	 * @param isActive Whether or not the technician is active.
	 * @param isSuper Whether the technician should be a supervisor or not.
	 */
	public Technician(int id, String first, String last, String hireD, 
			String phone, String email, int supervisor, boolean isActive, 
			boolean isSuper)
	{
		super(id, first, last, hireD, phone, email, DEPARTMENT);
		this.superID = supervisor;
		this.isActive = isActive;
		this.isSupervisor = isSuper;
		//The tickets are initialized in parent constructor since
		//A user has tickets too (the ones they opened).
	}

	/**
		Returns the supervisor's ID number.
		@return Supervisor's ID number.
	 */
	public int getSuperID() 
	{
		return superID;
	}

	/**
	 * Sets the supervisor's ID number.
	 * @param supID SUpervisor's ID number.
	 */
	public void setSupervisorID(int supID)
	{
		superID = supID;
	}



	/**
	Returns whether or not the technician is active.
	@return Status of the technician.
	 */
	public boolean isActive() 
	{
		return isActive;
	}

	/**
	 * Sets whether or not the technician is active
	 * @param iA status of the technician
	 */
	public void setIsActive(boolean iA)
	{
		isActive = iA;
	}

	/**
	 * Gets whether the technician is active or inactive
	 * @return a String stating whether the technician is active or inactive
	 */
	public String getIsActive()
	{
		String s = "";
		if (isActive)
			s = "Active";
		else
			s= "Inactive";
		return s;
	}

	/**
	 * Removes a ticket to this technician's assigned ticket list.
	 * @param ticket Ticket to assign to the technician
	 * @return true if the ticket was found and removed; false otherwise.
	 */
	public boolean removeTicket(Ticket ticket) 
	{
		boolean wasRemoved = associatedTickets.remove(ticket);

		if(!wasRemoved)
		{
			System.out.printf("The ticket with ID #%d was not assigned to technician with ID #%d" + 
					"and so could not be removed.", ticket.getTicketID(), this.empID);
		}

		return wasRemoved;
	}

	/**
	 * Gets the ID of the technician
	 * @return the ID of the technician
	 */
	public int getTechID()
	{
		return super.empID;
	}


	/**
		Sets whether or not the current technician is a supervisor.
		@param isSuper Whether the technician is a supervisor or not.
	 */
	public void setSupervisorStatus(boolean isSuper)
	{
		isSupervisor = isSuper;
	}

	/**
	Returns whether or not the technician is a supervisor.
	@return if the technician is a supervisor or not.
	 */
	public boolean isSupervisor() 
	{
		return isSupervisor;
	}


	/**
	 	Returns a string with all of the technician's information.
	 	@return String with with all technician information.
	 */
	@Override
	public String toString()
	{
		String ls = System.lineSeparator();

		String activeStr = "ACTIVE";

		if (!isActive)
			activeStr = "INACTIVE";

		return (super.toString() +
				ls + "Status: " + activeStr +
				ls + "Supervisor's ID: " + superID + 
				ls + "Are they a supervisor? " + isSupervisor);
	}

}