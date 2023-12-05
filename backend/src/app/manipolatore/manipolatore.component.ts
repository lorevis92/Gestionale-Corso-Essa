import { Component, OnInit } from '@angular/core';
import { IGiacenza } from '../models/IGiacenza';

@Component({
  selector: 'app-manipolatore',
  templateUrl: './manipolatore.component.html',
  styleUrls: ['./manipolatore.component.css']
})
export class ManipolatoreComponent implements OnInit {
  codice!: string;
  descrizione!: string;
  um!: string;
  giacenza!: number;
  acquistata!: number;
  venduta!: number;
  listaGiacenze: IGiacenza[] = [
    {
      "id": 1,
      "codice": "A",
      "descrizione": "Descrizione",
      "um": "PZ",
      "giacenza": 50,
      "acquistata": 20,
      "venduta": 0
    },
    {
      "id": 2,
      "codice": "V",
      "descrizione": "Descrizione",
      "um": "PZ",
      "giacenza": 50,
      "acquistata": 20,
      "venduta": 0
    }
  ];
  constructor() {}
  


  ngOnInit(): void {
  }

}
