## Vehicle Rental System

Question - https://docs.google.com/document/d/1a8iZKWDppQQxVJekNThZ1nhfmlMgrSG4zyYioEzI1S8/edit#heading=h.yztdg0tevkl0

## Solution

### Entities
- Branch
  - id
- Vehicle
  - id
  - registrationNumber
  - price // per unit time slot
  - timeSlot
  - vehicleType
- Booking
  - id
  - User
  - vehicle
  - bookingTime
- BranchManager
- BookingManager
- User
  - id
  - name
- Admin extends User
- Buyer extends User
- Seller extends User
- VehicleSelectionStrategy interface
- LowestPricedVehicle implements VehicleSelectionStrategy