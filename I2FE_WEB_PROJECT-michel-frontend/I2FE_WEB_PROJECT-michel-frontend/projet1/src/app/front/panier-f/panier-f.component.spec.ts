import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanierFComponent } from './panier-f.component';

describe('PanierFComponent', () => {
  let component: PanierFComponent;
  let fixture: ComponentFixture<PanierFComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PanierFComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PanierFComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
