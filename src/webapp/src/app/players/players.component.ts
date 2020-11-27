import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { ScraperService } from '../service/scraper.service';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent implements AfterViewInit {

  displayedColumns: string[] = ['year', 'name', 'position', 'height', 'weight', 'compositeRank', 'rankNational', 'rankPosition', 'rankState', 'stars'];
  dataSource = new MatTableDataSource();

  @ViewChild(MatSort) sort: MatSort;

  constructor(private scraperService: ScraperService) {
  }

  ngAfterViewInit() {
    console.log('Get Players');
    this.scraperService.getPlayers()
      .subscribe(result => {
        this.dataSource = new MatTableDataSource(result);
        this.dataSource.sort = this.sort;
      });
  }

}
