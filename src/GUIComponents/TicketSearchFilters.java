package GUIComponents;

/**
 * An enumeration for any ticket filter options you may want.
 *
 * HINT:  Add more filters for filtering on a tech's own ID
 *        or another tech's ID.
 * 
 * @author Andress Alkhawand - Hubert Whan Tong
 *
 *
 */
public enum TicketSearchFilters {

	NONE, OPEN, CLOSED, MINE;  //List of all possible filters - Only Filters that a user might need have been added thus far.
						 
	
	private static TicketSearchFilters[] userFilters =  {NONE, OPEN, CLOSED};  //just the ones users would need.
	private static TicketSearchFilters[] techFilters =  {NONE, OPEN, CLOSED,MINE};  //The ones technicians would need.

	/***
	 * Returns those filters appropriate for the given role.
	 * @param role The role of the person (The role defines which filters are possible)
	 * @return  An array of search filters allowed for users.
	 */
	public static TicketSearchFilters[] getFiltersForRole(LogonRole role)
	{
		if (role == LogonRole.USER)
		{
			return userFilters;
		}
		else
			return techFilters;

	
	}
}
