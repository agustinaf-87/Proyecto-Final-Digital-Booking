import { useState } from "react";
import HamburgerIcon from "../../../shared/Icons/HamburgerIcon";
import SideNav from "../SideNav/SideNav";
import './HeaderMenu.scss';

export default function HeaderMenu() {
    const [closeSideNav, setCloseSideNav] = useState(true);

    const toggleSidePanel = () => {
        setCloseSideNav(!closeSideNav);
    }

    return (
        <div className="db-header-menu">
            <div onClick={toggleSidePanel}>
                <HamburgerIcon />
            </div>
            {closeSideNav ? null : <SideNav close={toggleSidePanel}/>}
        </div>
    )
}