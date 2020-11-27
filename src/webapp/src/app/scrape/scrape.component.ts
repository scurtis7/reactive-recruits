import { Component, OnInit } from '@angular/core';
import { Player247 } from '../model/player247';
import { ScraperService } from '../service/scraper.service';
import { College } from '../model/college';
import { CollegeService } from '../service/college.service';

@Component({
  selector: 'app-scrape',
  templateUrl: './scrape.component.html',
  styleUrls: ['./scrape.component.css']
})
export class ScrapeComponent implements OnInit {

  players: Player247[] = [];
  colleges: College[] = [];

  constructor(private scraperService: ScraperService, private collegeService: CollegeService) {
  }

  ngOnInit() {
    // this.players = [
    //   {siteId:"siteId", name:"name", position: "position", height:"height", weight:"weight", homeTown:"homeTown", highSchool:"highSchool", year:"year", compositeRank:"cRank", rankNational:"nRank", rankPosition:"pRank", rankState:"sRank", stars:"stars", link:"link"}
    // ]
    // this.colleges = [
    //   {id: 1, siteName: 'florida-state', displayName: 'Florida State University', conference: 'ACC', division: 'Atlantic'},
    //   {id: 2, siteName: 'georgia', displayName: 'University of Georgia', division: '', conference: ''},
    //   {id: 3, siteName: 'auburn', displayName: 'Auburn University', conference: '', division: ''},
    //   {id: 4, siteName: 'alabama', displayName: 'University of Alabama', conference: '', division: ''}
    // ];
    this.loadAllColleges();
  }

  loadAllColleges() {
    this.collegeService.getAllColleges()
      .subscribe(result => {
        this.colleges = result;
      });
  }

  scrape(college: string, year: string) {
    console.log('Scrape 247 Season: college -> ' + college + '  year -> ' + year);
    this.scraperService.scrape(college, year)
      .subscribe(result => {
        this.players = result;
      });
  }

}
