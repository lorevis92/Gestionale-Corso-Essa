import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManipolatoreComponent } from './manipolatore.component';

describe('ManipolatoreComponent', () => {
  let component: ManipolatoreComponent;
  let fixture: ComponentFixture<ManipolatoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManipolatoreComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManipolatoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
