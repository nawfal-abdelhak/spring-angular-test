
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HelpersService {
  shownav: boolean = true



  formatDateMonthName(date: Date) {
    if (!date) return "";
    let newDate = new Date(date);
    let year = newDate.getFullYear();
    let month = (newDate.getMonth() + 1) < 10 ? "0" + (newDate.getMonth() + 1) : (newDate.getMonth() + 1);
    let day = newDate.getDate() < 10 ? "0" + newDate.getDate() : newDate.getDate();
    const monthNames = ["January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December"
    ];

    var days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    var dayName = days[newDate.getDay()];
    let hours = newDate.getHours() < 10 ? "0" + newDate.getHours() : newDate.getHours();
    let minutes = newDate.getMinutes() < 10 ? "0" + newDate.getMinutes() : newDate.getMinutes();
    return dayName + " " + day + " " + monthNames[newDate.getMonth()] + " " + year + " " + hours + ":" + minutes;
  }
}
