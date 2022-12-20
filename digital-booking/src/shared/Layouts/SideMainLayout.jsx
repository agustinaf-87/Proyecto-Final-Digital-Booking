import './SideMainLayout.scss';

export default function SideMainLayout({side, main}) {
    return (
        <div className='db-side-main-layout'>
            <div className='side'>
                {side}
            </div>
            <div className='main'>
                {main}
            </div>
        </div>
    )
}