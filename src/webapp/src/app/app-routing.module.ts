import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PlayersComponent} from './players/players.component';
import {ScrapeComponent} from './scrape/scrape.component';
import {AboutComponent} from './about/about.component';
import {SigninComponent} from './signin/signin.component';

const routes: Routes = [
  {path: 'players', component: PlayersComponent},
  {path: 'scrape', component: ScrapeComponent},
  {path: 'about', component: AboutComponent},
  {path: 'signin', component: SigninComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
