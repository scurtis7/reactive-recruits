import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutComponent } from './about/about.component';
import { SigninComponent } from './signin/signin.component';
import { PlayersComponent } from './players/players.component';
import { ScrapeComponent } from './scrape/scrape.component';
import { HttpClientModule } from '@angular/common/http';
import { ScraperService } from './service/scraper.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    SigninComponent,
    PlayersComponent,
    ScrapeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSortModule,
    MatTableModule
  ],
  providers: [
    ScraperService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
