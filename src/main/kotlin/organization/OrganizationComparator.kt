package organization

class OrganizationComparator : Comparator<Organization?> {
    override fun compare(a: Organization?, b: Organization?): Int {
        if (a!!.getEmployeesCount() === b!!.getEmployeesCount()) {
            return 0
        }
        return if ( a!!.getEmployeesCount()!! > b!!.getEmployeesCount()!! ) {
            1
        } else {
            -1
        }
    }
}